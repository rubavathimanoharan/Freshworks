# Create , Delete and Read OPerations in a file  <br /><br /><br />
## JAR FILES USED:<br />
json-simple-1.1.1.jar<br />
json-20201115.jar<br />
## FUNCTIONS USED:<br />
### 1.INSERT:<br />
i.create a file in any location.<br />
ii.Get input from the user using Scanner.<br /> 
iii.Create a json object and add all the inputs inside the json file using the json objects.<br />
iv.After adding the inputs constantly check whether the file size does not exceed 1GB.<br />
v.Also check the key value pair are unique by calling the method check.<br />
### 2.CHECK:<br />
i.Parse the json file using JSONParser and check the key value pairs.<br />
ii.If the key is unique then return 1 else return 0.<br />
### 3.READ:<br />
I.Create a json object and parse the json the file. <br />
ii.Read the inputs from the file usinf buffer reader.<br />
iii.Ask the key which user wants to read.<br />
iv.Display the output.<br />
### 4.DELETE:<br />
i.get the input from user which key value pair the use want to delete.<br />
ii.Delete the required key value pair.<br />
iii.Rewrite the content of the file using Printwriter.<br />
### 5.MAIN<br />
i.Create an object.<br />
ii.Get an input from the user which operation the use wants to do.<br />
iii.Perform the required operations.<br />
