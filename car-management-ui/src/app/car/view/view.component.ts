import { Component } from '@angular/core';

import { CommonModule } from '@angular/common';
import { ActivatedRoute } from '@angular/router';
import { CarService } from '../../service/car.service';
import { Car } from '../../model/car';

@Component({
  selector: 'app-view',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './view.component.html',
  styleUrl: './view.component.css'
})
export class ViewComponent {

  car?: Car

  constructor(
    private route: ActivatedRoute,
    public carService: CarService
  ) { }

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('carId');
    if (id) {
      this.carService.getById(id).subscribe((data: Car) => {
        this.car = data;
      });
    }
  }
}
