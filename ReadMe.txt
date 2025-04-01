1.Create Maven project with Java latest version. Example. java 17

2. Select Archetype as quickstart.

3. Add the latest dependencies in pom.xml.(selenium,java, testng, web-driver manager)
WebDriver manager is to automatically manage browser drivers.You don't need to add a drivers folder in your project structure
if you're using WebDriverManager. The main purpose of WebDriverManager is to automatically download and manage the browser driver binaries for you.
It eliminates the need to manually download drivers and store them in a specific folder within your project.

4.Create testng.xml and give there path in pom.xml So that maven will execute tests mentioned in testng.xml.

5. Add Template in testng.xml

6. Add two more dependencies to avoid error of No SLF4J providers were found.(openxml4j,slf4j-simple)

7. If we are getting No tests were found then always check that Tests are present in Test classes.
example. @test should be present. Only @BeforeClass and @AfterClass won't work.