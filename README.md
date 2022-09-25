
Application, which works with GitHub REST API.

Response contains of: 
+ Repository Names (of given User)
+ Owner Login

Controller provides listing more details like non-forks repositories.
For each branch it's name and last commit sha is displayed.
Given non-existing GitHub user will cause an exception to be thrown,

*App is composed on Java 17.*
Documentation for Rest API might be found here -> <https://developer.github.com/v3>

