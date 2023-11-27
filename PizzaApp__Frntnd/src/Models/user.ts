import { pizzaMeal } from "./pizzaMeal";

export type User={
    email:string;
    password:string;
    userName?:string;
    phoneNo?:number;
    pizza:pizzaMeal[];
}