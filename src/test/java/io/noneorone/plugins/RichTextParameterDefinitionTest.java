package io.noneorone.plugins;

import hudson.model.ParametersDefinitionProperty;
import org.jenkinsci.plugins.workflow.cps.CpsFlowDefinition;
import org.jenkinsci.plugins.workflow.job.WorkflowJob;
import org.jenkinsci.plugins.workflow.job.WorkflowRun;
import org.junit.Rule;
import org.junit.Test;
import org.jvnet.hudson.test.JenkinsRule;

public class RichTextParameterDefinitionTest {

    @Rule
    public JenkinsRule jenkins = new JenkinsRule();

    final String name = "Bobby";

    @Test
    public void testScriptedPipeline() throws Exception {
/*
        RichTextParameterDefinition parameterDefinition = new RichTextParameterDefinition(name);

        WorkflowJob job = jenkins.createProject(WorkflowJob.class, "test-scripted-pipeline");
        job.addProperty(new ParametersDefinitionProperty(parameterDefinition));
        String pipelineScript
                = "node {\n"
                + "  print params['" + name + "'] \n"
                + "}";
        job.setDefinition(new CpsFlowDefinition(pipelineScript, true));
        WorkflowRun completedBuild = jenkins.assertBuildStatusSuccess(job.scheduleBuild2(0));

        String expectedString = name;
        jenkins.assertLogContains(expectedString, completedBuild);
*/
    }

}