**# learning-graphql-java**

**Prerequisites:**
1.  Download latest Gradle: https://gradle.org/releases

**Steps to execute the examples:**
1.  After setting up the project - build using `gradle build` command - that will download the dependencies
2.  Run clients contained in "clients" package in the following order:<br>
    `a.  FirstGraphQLClient:` This is GraphQL HelloWorld example<br> 
    `b.  MyGraphQLClient:` This is illustrates well packaged graphql-java. Has well defined service -> datafetcher -> graphql schema -> client<br>
    `c.  To run graphql:`<br>
        i.      Do gradle build using `gradle build` command<br> 
        ii.     Execute `java -jar build/libs/learning-graphql-java-1.0.0.jar` from command prompt<br>
        iii.    After the server starts - try running `localhost:8080/home` and `localhost:8080/query` from browser