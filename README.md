# Rest Client Interceptors

This is a project for the demonstration of Rest client interceptor functionality and its usage

## Running the test

- From your favourite IDE, execute the `TodoServiceTest`. 

- After the test is successful, in the logs, you'll be able to see the following:
  <br/>`Intercepting Request: https://jsonplaceholder.typicode.com/todos`
  <br/>This shows that the Interceptor is working.
- In this simple example, we have added a header through the interceptor. If you want to see the actual request being sent, Edit the JUnit configuration through your IDE for the test and add the following command line arg to the Java VM:
  <br/>`-Djdk.httpclient.HttpClient.log=all`
  <br/>This will show the complete request info and the headers. Here, you can see the newly added header: <br/>`x-request-id: 1234`

---

## Note

This is only a simple usage example to show how the interceptor intercepts a request and can modify it. Thus, the usage of Rest Interceptors only to add/modify headers is not a good practice. It is advisable to make use of the `RestClient` itself for such simple tasks.

The Rest Interceptor can be used for more complex tasks such as creating a Retry mechanism for Rest API invocations.
