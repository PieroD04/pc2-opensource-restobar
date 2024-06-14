package biz.restobar.platform.u202210749.attention.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

/**
 * Value object countPerson
 * <p>
 *     This value object represents the number of people in a reservation.
 * </p>
 * @param countPerson the number of people in a reservation. That's why its value must be greater than 0.
 * @author Piero Gonzalo Delgado Corrales
 * @version 1.0
 */
@Embeddable
public record PersonCount(Long countPerson) {
    /**
     * Default constructor
     * <p>
     *    It sets the countPerson to 0 if no value is provided.
     * </p>
     * @author Piero Gonzalo Delgado Corrales
     */
    public PersonCount(){
        this(0L);
    }

    /**
     * Constructor
     * <p>
     *     It creates a new instance of PersonCount with the provided countPerson.
     *     It validates that the countPerson is greater than 0.
     * </p>
     * @param countPerson the number of people in a reservation.
     * @throws IllegalArgumentException if the countPerson is less than or equal to 0.
     * @author Piero Gonzalo Delgado Corrales
     */
    public PersonCount {
        if (countPerson <= 0) {
            throw new IllegalArgumentException("countPerson cannot be less than or equal to 0");
        }
    }
}
