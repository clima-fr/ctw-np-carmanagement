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
    const id = this.route.snapshot.paramMap.get('carId');
    if (id) {
      this.carService.getById(id).subscribe((data: Car) => {
        this.car = data;
      });
    }
  }

  onFileSelected(event: any): void {
    const file: File = event.target.files[0];
    if (!file) {
      return; 
    }
    if (file.size > 2 * 1024 * 1024) { 
      alert("File too large. Please upload an image smaller than 2MB.");
      event.target.value = '';
      return;
    }
    const reader = new FileReader();
    reader.onload = () => {
      this.car.image = reader.result as string;
    };
    reader.readAsDataURL(file);
  }

  removeImage(): void {
    this.car.image = ''; 
  }
  
  updateCar(): void {
    this.carService.update(this.car).subscribe({
      next: () => {
        this.message = 'Car updated successfully!';
      },
      error: (err: any) => {
        this.message = 'Error updating car: ' + err;
      }
    });
  }

}
