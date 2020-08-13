# Alexa and Google Assistant test
Returns CS:GO inventory value using csgobackpack.net
<br>
<br>
Code in this repo is meant to run in AWS lambda and be invoked through API gateway by Dialogflow or Alexa console.
<br>
<br>
<br>
<br>
[Alexa developer console](https://developer.amazon.com/alexa/console/ask)

[AWS management console](https://eu-north-1.console.aws.amazon.com/console/home?region=eu-north-1#)

[Amazon API Gateway](https://eu-north-1.console.aws.amazon.com/apigateway)

[Dialogflow](https://dialogflow.cloud.google.com/)

[Google Actions](https://console.actions.google.com/)

<br>
<br>
<br>
To run, replace steamID in config.properties file with an actual ID and run csgoInventory.TestExecutable

To build JAR for AWS, run "gradle fatJar"
<br>
Flow: Google Actions -> Dialogflow -> Amazon API Gateway -> AWS Lambda -> 3rd party web service.