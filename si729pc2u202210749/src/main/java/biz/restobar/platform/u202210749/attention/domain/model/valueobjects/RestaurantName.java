package biz.restobar.platform.u202210749.attention.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

/**
 * Value object NameRestaurant.
 * <p>
 *     This value object represents the name of the restaurant in a reservation.
 *     It validates that the name of the restaurant is not null, empty or longer than 50 characters.
 * </p>
 * @param nameRestaurant the name of the restaurant in a reservation. That's why its value must be required and cant be empty.
 *                       Also, it cannot be longer than 50 characters.
 * @author Piero Gonzalo Delgado Corrales
 * @version 1.0
 */

@Embeddable
public record RestaurantName(String nameRestaurant) {
    /**
     * Default constructor
     * <p>
     *    It sets the name of the restaurant to null if no value is provided.
     * </p>
     * @author Piero Gonzalo Delgado Corrales
     */

    public RestaurantName() {
        this(null);
    }

    /**
     * Constructor for the RestaurantName value object.
     * <p>
     *     It validates that the name of the restaurant is not null, empty or longer than 50 characters.
     * </p>
     * @param nameRestaurant represents the name of the restaurant in a reservation.
     * @throws IllegalArgumentException if the nameRestaurant is null, empty or longer than 50 characters.
     * @author Piero Gonzalo Delgado Corrales
     */
    public RestaurantName {
        if (nameRestaurant == null) {
            throw new IllegalArgumentException("nameRestaurant is required");
        }

        if (nameRestaurant.isBlank()) {
            throw new IllegalArgumentException("nameRestaurant cannot be empty");
        }

        if (nameRestaurant.length() > 50) {
            throw new IllegalArgumentException("nameRestaurant cannot be longer than 50 characters");
        }
    }
}
