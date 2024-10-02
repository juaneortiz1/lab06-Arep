package com.example.accessingdatajpa.controller;

import com.example.accessingdatajpa.model.Property;
import com.example.accessingdatajpa.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * The PropertyController class handles HTTP requests related to property management.
 * It provides RESTful endpoints for creating, reading, updating, and deleting properties.
 *
 */
@RestController
@RequestMapping("/properties")
public class PropertyController {

    @Autowired
    private PropertyRepository propertyRepository;

    /**
     * Creates a new property.
     *
     * @param property The property object to be created, passed in the request body.
     * @return A ResponseEntity containing the created Property and HTTP status 201 (Created).
     */
    @PostMapping
    public ResponseEntity<Property> createProperty(@RequestBody Property property) {
        Property savedProperty = propertyRepository.save(property);
        return new ResponseEntity<>(savedProperty, HttpStatus.CREATED);
    }

    /**
     * Retrieves a list of all properties.
     *
     * @return A List of Property objects representing all properties in the database.
     */
    @GetMapping
    public List<Property> getAllProperties() {
        return (List<Property>) propertyRepository.findAll();
    }

    /**
     * Retrieves a property by its ID.
     *
     * @param id The ID of the property to retrieve.
     * @return A ResponseEntity containing the Property if found, or HTTP status 404 (Not Found) if not.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Property> getPropertyById(@PathVariable Long id) {
        Optional<Property> property = propertyRepository.findById(id);
        return property.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Updates an existing property by its ID.
     *
     * @param id The ID of the property to update.
     * @param propertyDetails The updated property details, passed in the request body.
     * @return A ResponseEntity containing the updated Property if successful, or HTTP status 404 (Not Found) if the property does not exist.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Property> updateProperty(@PathVariable Long id, @RequestBody Property propertyDetails) {
        Optional<Property> optionalProperty = propertyRepository.findById(id);
        if (optionalProperty.isPresent()) {
            Property property = optionalProperty.get();
            property.setAddress(propertyDetails.getAddress());
            property.setPrice(propertyDetails.getPrice());
            property.setSize(propertyDetails.getSize());
            property.setDescription(propertyDetails.getDescription());
            Property updatedProperty = propertyRepository.save(property);
            return ResponseEntity.ok(updatedProperty);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Deletes a property by its ID.
     *
     * @param id The ID of the property to delete.
     * @return A ResponseEntity with HTTP status 204 (No Content) if successful, or HTTP status 404 (Not Found) if the property does not exist.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProperty(@PathVariable Long id) {
        if (propertyRepository.existsById(id)) {
            propertyRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
