import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { CarService } from '../../service/car.service';
import { Car } from '../../model/car';

@Component({
  selector: 'app-edit',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './edit.component.html',
  styleUrl: './edit.component.css'
})
export class EditComponent {
  car: Car = {} as Car;
  message: string = '';

  constructor(
    private carService: CarService, 
    private route: ActivatedRoute
  ) {}

   ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
      this.carService.getById(id).subscribe((data: Car) => {
        this.car = data;
      });
    }
  }
  
  updateCar(): void {
    this.carService.update(this.car).subscribe({
      next: () => {
        this.message = 'Car updated successfully!';
        this.car = {} as Car;
      },
      error: (err: any) => {
        this.message = 'Error updating car: ' + err;
      }
    });
  }

}
