package io.noneorone.plugins;

import hudson.model.*;

import jenkins.model.Jenkins;
import org.kohsuke.stapler.Stapler;

public class ProjectUtils {
    public static Job<?, ?> getCurrentProject(ParameterDefinition thisParameter) {
        try {
            Job<?, ?> job = Stapler.getCurrentRequest().findAncestorObject(Job.class);
            if (job != null) {
                String uri = Stapler.getCurrentRequest().getRequestURI();
                return uri.endsWith("/build") || uri.endsWith("/buildWithParameters") ? job : null;
            }
        } catch (Exception ignored) {
        }

        try {
            for (Job<?, ?> job : Jenkins.get().getAllItems(Job.class)) {
                ParametersDefinitionProperty property = job.getProperty(ParametersDefinitionProperty.class);
                if (property != null)
                    for (ParameterDefinition parameter : property.getParameterDefinitions())
                        if (parameter == thisParameter)
                            return job;
            }
        } catch (Exception ignored) {
        }

        return null;
    }

    public static ParameterValue getLastValue(SimpleParameterDefinition parameter, boolean successfulOnly) {
        Job<?, ?> job = ProjectUtils.getCurrentProject(parameter);
        if (job != null) {
            Run<?, ?> lastBuild = (successfulOnly ? job.getLastSuccessfulBuild() : job.getLastBuild());
            if (lastBuild != null) {
                for (ParametersAction pa : lastBuild.getActions(ParametersAction.class)) {
                    return pa.getParameter(parameter.getName()); // there should normally be only one ParametersAction
                }
            }
        }
        return null;
    }
}