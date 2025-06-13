function loadPersons() {
  fetch('/persons')
    .then(res => res.json())
    .then(data => {
      const table = document.getElementById('personTable');
      table.innerHTML = '';
      data.forEach(person => {
        table.innerHTML += `
          <tr>
            <td>${person.id}</td>
            <td>${person.name}</td>
            <td>${person.age}</td>
            <td>
              <button onclick='editPerson(${JSON.stringify(person)})'>Edit</button>
              <button onclick='deletePerson(${person.id})'>Delete</button>
            </td>
          </tr>`;
      });
    });
}

function editPerson(person) {
  document.getElementById('id').value = person.id;
  document.getElementById('name').value = person.name;
  document.getElementById('age').value = person.age;
}

function savePerson(event) {
  event.preventDefault();
  const person = {
    id: document.getElementById('id').value,
    name: document.getElementById('name').value,
    age: document.getElementById('age').value
  };

  fetch('/persons', {
    method: 'POST',
    headers: {'Content-Type': 'application/json'},
    body: JSON.stringify(person)
  })
  .then(() => {
    document.getElementById('personForm').reset();
    loadPersons();
  });
}
