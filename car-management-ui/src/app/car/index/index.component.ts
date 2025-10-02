import { Component } from '@angular/core';

import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { CarService } from '../../service/car.service';
import { Car } from '../../model/car';

@Component({
  selector: 'app-index',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './index.component.html',
  styleUrl: './index.component.css'
})
export class IndexComponent {

  cars: Car[] = [];
  message: string = '';

  constructor(public carService: CarService) { }
      
  /**
   * Write code on Method
   *
   * @return response()
   */
  ngOnInit(): void {
    this.carService.getAll().subscribe((data: Car[])=>{
      this.cars = data;
    })  
  }
  deleteCar(id: string): void {
    this.carService.delete(id).subscribe({
      next: () => {
        this.message = 'Car removed successfully!';
        this.carService.getAll();
      },
      error: (err) => {
        this.message = 'Error removing car: ' + err;
      }
   });
  }
}
