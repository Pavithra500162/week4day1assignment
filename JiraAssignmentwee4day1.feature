Feature: Jira incident Management

Background:
Given Set the Endpoint
And set the auth

Scenario Outline: Create the Jira incident
When Create new incident with file '<filename>'
Then Vaildate the status code as 201

Examples:
|filename|
|Jiracreateinc.json|


Scenario: Update inc jira
When update the incident body '{"fields": {"description": "Bug creation Using REST API for testing"}}'
Then Vaildate the status code as 204

Scenario: Get JIRA incident
When get the incident
Then Vaildate the status code as 200

Scenario: Delete the incident
When delete the incident
Then Vaildate the status code as 204
