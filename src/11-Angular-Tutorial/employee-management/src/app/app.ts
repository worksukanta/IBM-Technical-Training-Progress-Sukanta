import { Component, signal } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {

  employees = signal([
    {
      id:1,
      name:"Sukanta",
      department:"IT",
      salary:45000
    },
    {
      id:2,
      name:"Rahul",
      department:"HR",
      salary:40000
    },
    {
      id:3,
      name:"Priya",
      department:"Finance",
      salary:52000
    }
  ]);

  addEmployee() {

    this.employees.update(list => [
      ...list,
      {
        id: list.length + 1,
        name: "New Employee",
        department: "Support",
        salary: 30000
      }
    ]);

  }

}