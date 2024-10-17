const taskForm = document.getElementById('task-form');  
const taskList = document.getElementById('task-list');  
  
taskForm.addEventListener('submit', (e) => {  
   e.preventDefault();  
   const title = document.getElementById('title').value;  
   const description = document.getElementById('description').value;  
   const task = { title, description, isCompleted: false };  
   fetch('/api/tasks', {  
      method: 'POST',  
      headers: { 'Content-Type': 'application/json' },  
      body: JSON.stringify(task),  
   })  
      .then((response) => response.json())  
      .then((data) => {  
        console.log(data);  
        taskList.innerHTML += `  
           <li>  
              <span>${data.title}</span>  
              <span>${data.description}</span>  
              <button class="complete-btn">Complete</button>  
              <button class="delete-btn">Delete</button>  
           </li>  
        `;  
      })  
      .catch((error) => console.error(error));  
});  
  
taskList.addEventListener('click', (e) => {  
   if (e.target.classList.contains('complete-btn')) {  
      const taskId = e.target.parentNode.dataset.id;  
      fetch(`/api/tasks/${taskId}`, {  
        method: 'PUT',  
        headers: { 'Content-Type': 'application/json' },  
        body: JSON.stringify({ isCompleted: true }),  
      })  
        .then((response) => response.json())  
        .then((data) => {  
           console.log(data);  
           e.target.parentNode.classList.add('completed');  
        })  
        .catch((error) => console.error(error));  
   } else if (e.target.classList.contains('delete-btn')) {  
      const taskId = e.target.parentNode.dataset.id;  
      fetch(`/api/tasks/${taskId}`, {  
        method: 'DELETE',  
      })  
        .then((response) => response.json())  
        .then((data) => {  
           console.log(data);  
           e.target.parentNode.remove();  
        })  
        .catch((error) => console.error(error));  
   }  
});