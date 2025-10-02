package com.ctw.car.boundary;

import com.ctw.car.control.CarService;
import com.ctw.car.entity.Car;
import com.ctw.car.entity.Routes;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.UUID;

@Path(Routes.CAR)
@ApplicationScoped
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CarResource { 

    private final CarService carService;

    @Inject
    public CarResource(final CarService carService) {
        this.carService = carService;
    }

    @GET
    public Response getCars(
            @QueryParam("brand") String brand
    ) {
        List<Car> cars = this.carService.getCars();
        return Response.status(200).entity(cars).build();
    }

    @GET
    @Path("/{id}")
    public Response getCarById(@PathParam("id") String id) {
    Car car = this.carService.getCarById(id);
    if (car == null) {
        return Response.status(Response.Status.NOT_FOUND).build();
    }
    return Response.ok(car).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateCar(@PathParam("id") String id, Car car) {
        Car updatedCar = carService.updateCar(id, car);
        if (updatedCar == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(updatedCar).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteCar(@PathParam("id") String id) {
        boolean deleted = carService.deleteCar(id);

        if (!deleted) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.noContent().build(); 
    }


    @POST
    public Response createCar(Car car) {
    Car createdCar = this.carService.createCar(car);
    return Response.status(Response.Status.CREATED).entity(createdCar).build();
    }

}
