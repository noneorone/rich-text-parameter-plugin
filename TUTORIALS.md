# rich-text-parameter-plugin

## 资料
* [Jenkins插件开发](http://events.jianshu.io/p/5224b7436778)
* [Jenkins插件官方教程](https://www.jenkins.io/zh/doc/developer/tutorial/)
* [编写流水线兼容的插件](https://www.jenkins.io/zh/doc/developer/plugin-development/pipeline-integration/)
* [Jenkins插件开发入门指南](https://juejin.cn/post/6844903492503502855)
* [最最最全的Jenkins插件开发教程](https://www.daimajiaoliu.com/daima/4762226ea1003e4)
* [Jenkins插件开发完全示例-参数化构建](https://www.cnblogs.com/bluersw/p/13131916.html) ([ParameterDefinition](https://www.jenkins.io/doc/developer/extensions/jenkins-core/#parameterdefinition))

## 第三方库
* [Kind Editor](http://kindeditor.net/demo.php)
  > [官方下載](http://kindeditor.net/down.php)  
  > [编辑器初始化参数](http://kindeditor.net/docs/option.html)  
  > [编辑器使用方法](http://kindeditor.net/docs/usage.html)  
* [Yahoo YUI](https://clarle.github.io/yui3/) <sup>[github](https://github.com/yui)</sup>
  > [YUI2.9](http://yui.github.io/yui2/docs/yui_2.9.0_full/) → [github](https://github.com/yui/yui2)  
  > [YUI2 RichTextEditor](http://yui.github.io/yui2/docs/yui_2.9.0_full/editor/index.html#rendering)  
  > [YUI2.X皮肤css](http://yui.yahooapis.com/2.9.0/build/assets/skins/sam/skin.css)  
* [Quill Rich Text Editor](https://quilljs.com/)
  > [How to Customize Quill](https://quilljs.com/guides/how-to-customize-quill/)  
  > [TypeError: this.each is not a function #1261](https://github.com/quilljs/quill/issues/1261)  
  > [fix: this.each is not a function for prototype.js #431](https://github.com/facebook/fbjs/pull/431)  
  > [fix: fix this.each is not a function #1](https://github.com/tungbt94/quill/pull/1)
* [CKEditor](https://ckeditor.com/docs/ckeditor5/latest/index.html)
  > [快速入门](https://ckeditor.com/docs/ckeditor5/latest/installation/getting-started/quick-start.html)

## 开源插件参考
* [agent-server-parameter-plugin](https://github.com/jenkinsci/agent-server-parameter-plugin)
* [persistent-parameter-plugin](https://github.com/jenkinsci/persistent-parameter-plugin)
* [active-choices-plugin](https://github.com/jenkinsci/active-choices-plugin)
* [extended-choice-parameter-plugin](https://github.com/jenkinsci/extended-choice-parameter-plugin)
* [build-failure-analyzer-plugin](https://github.com/jenkinsci/build-failure-analyzer-plugin)

## 流程
* jenkins插件模板： [hello-world-plugin](https://github.com/jenkinsci/archetypes/tree/master/hello-world)
* 通过模块来生成jenkins插件工程
```shell
mvn archetype:generate -B -DarchetypeGroupId=io.jenkins.archetypes -DarchetypeArtifactId=hello-world-plugin -DhostOnJenkinsGitHub=true -DarchetypeVersion=1.7 -DartifactId=rich-text-parameter
```