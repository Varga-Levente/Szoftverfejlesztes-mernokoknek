# Testing Spring REST Mapping
- Created Demo model
  - Removed String id;
  - Changed String age; --> int age;
  - Changed String birthDate; --> Date birthDate;
  - Removed and changed all getters and setters
- Created DemoController
  - Created a HashMap<String, Demo> to store the data
  - Filled the HashMap with some data
    - Modified the data to match the new model
  - Modified (/people) endpoint to return the HashMap with key and value pairs
  - Added @RequestBody to (/person) endpoint to receive a JSON object
  - Created DeletedMapping for person (/person/{id})
    - Added @PathVariable to receive the id from the URL
    - If the id is found in the HashMap, the person is removed and a message is returned
    - If the id is not found in the HashMap, a message is returned

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