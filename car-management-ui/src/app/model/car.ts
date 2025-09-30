export interface Car {
    id: string,
    brand: string,
    model: string,
    engineType: string,
    seats?:number;
    licensePlate?: string;
    autonomy?: number;
    color?:string;
    image?:string;
}
