# Testing Spring REST Mapping
- Created Demo model
  - Created String id;
  - Created String name;
  - Created String age;
    - (It will be an integer in the future)
  - Created String birthPlace;
  - Created String birthDate;
    - (It will be a date in the future)
  - Created all getters and setters
  - Created a constructor with all fields
- Created DemoController
  - Created a HashMap<String, Demo> to store the data
  - Filled the HashMap with some data
  - Created default (/) endpoint
    - (Returns "Hello World")
  - Created people (/people) endpoint
    - (Returns all the data from the HashMap as a HTML format)
  - Created people/{id} endpoint
    - (Returns the data from the HashMap with the given id as a HTML format)
  - Created person (POST) (/person) endpoint
    - (Adds a new person to the HashMap)
- Created DemoService

# To add new data to the HashMap use this code in browser console:
```js
(async function createPerson() {

    let demo = {
        "name": "John Doe",
        "age": "30",
        "birthPlace": "New York",
        "birthDate": "2000-01-01"
    };

    await fetch('http://localhost:8080/person', {
        method: "POST",
        headers: {
            Accept: 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(demo)
    })
    .then(result => result.text())
    .then(text => alert(text));
})();
```