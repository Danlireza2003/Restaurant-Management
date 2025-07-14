Thanks for seeing the project. My API is running on the port: 8080  and my FrontEnd is running on the 5175 port r. Of course connecting different ports could be a problem because of CORS, so I added a notation on the Spring Boot API: @CrossOrigin(origins ="*",allowedHeaders = "*")
This annotation allows that any origin has access to my endpoints.

I used the Intellij IDE for building the Java APi and VSCode for my React app. The database I did choose was the PostGreSQL database.
If you want to improve the application even more, feel free to clone and do a PR.
