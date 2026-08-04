let message: string = "Hello World";

console.log(message);

function sum (a:number, b:number):number {
    return a+b;
}

console.log(sum(10, 20));

let greet = (msg: string):string =>{
    console.log(msg);
    return msg;
}

greet("Heyyyyyyyy");


interface Operation{
    calculate(a:number, b:number):number;
}

class Addition implements Operation{
    calculate(a:number, b:number):number {
        return a+b;
    }
}

class Multiplication implements Operation{
    calculate(a: number, b: number): number {
        return a*b;
    }
}

let add = new Addition();
console.log(add.calculate(11, 30));

let multiply = new Multiplication();
console.log(multiply.calculate(11.5, 30.5));

let add_obj: Operation = {
    calculate: (a, b) => a + b
};

let mul_obj: Operation = {
    calculate: (a, b) => a * b
};

console.log(add_obj.calculate(40, 50));
console.log(mul_obj.calculate(40, 50));


interface User{
    id: number;
    name: string;
    age?: number; // Optional property
}

let user1: User = {id: 10, name: "Sukanta", age: 24};
let user2: User = {id: 11, name: "Vaishnavi"};
// let user3: User = {id: 27};

console.log(user1.name, "and", user2.name);
// console.log(user3.id);

class Car{
    public brand: string;
    public max_speed: number;
    private vehicle_number?: string;

    constructor(brand: string, max_speed: number, vehicle_number?: string){
        this.brand = brand;
        this.max_speed = max_speed;
        this.vehicle_number = vehicle_number;
    }
    
    public getVehicle_number():string{
        return this.vehicle_number?this.vehicle_number:"Unregistered";
    }

}

let car1:Car = new Car("BMW", 350, "XYZ-1234");
let car2: Car = new Car("Tesla", 250);

console.log("Brand:", car1.brand, "Top Speed (kmph):", car1.max_speed, "Vehicle Number:", 
                                                                        car1.getVehicle_number());
console.log("Brand:", car2.brand, "Top Speed (kmph):", car2.max_speed, "Vehicle Number:", 
                                                                        car2.getVehicle_number());



