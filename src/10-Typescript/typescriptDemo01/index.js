"use strict";
let message = "Hello World";
console.log(message);
function sum(a, b) {
    return a + b;
}
console.log(sum(10, 20));
let greet = (msg) => {
    console.log(msg);
    return msg;
};
greet("Heyyyyyyyy");
class Addition {
    calculate(a, b) {
        return a + b;
    }
}
class Multiplication {
    calculate(a, b) {
        return a * b;
    }
}
let add = new Addition();
console.log(add.calculate(11, 30));
let multiply = new Multiplication();
console.log(multiply.calculate(11.5, 30.5));
let add_obj = {
    calculate: (a, b) => a + b
};
let mul_obj = {
    calculate: (a, b) => a * b
};
console.log(add_obj.calculate(40, 50));
console.log(mul_obj.calculate(40, 50));
let user1 = { id: 10, name: "Sukanta", age: 24 };
let user2 = { id: 11, name: "Vaishnavi" };
// let user3: User = {id: 27};
console.log(user1.name, "and", user2.name);
// console.log(user3.id);
class Car {
    brand;
    max_speed;
    vehicle_number;
    constructor(brand, max_speed, vehicle_number) {
        this.brand = brand;
        this.max_speed = max_speed;
        this.vehicle_number = vehicle_number;
    }
    getVehicle_number() {
        return this.vehicle_number ? this.vehicle_number : "Unregister";
    }
}
let car1 = new Car("BMW", 350, "XYZ-1234");
let car2 = new Car("Tesla", 250);
console.log("Brand:", car1.brand, "Top Speed (kmph):", car1.max_speed, "Vehicle Number:", car1.getVehicle_number());
console.log("Brand:", car2.brand, "Top Speed (kmph):", car2.max_speed, "Vehicle Number:", car2.getVehicle_number());
