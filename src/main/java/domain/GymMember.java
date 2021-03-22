package domain;

import java.time.LocalDate;
import java.util.Objects;

public class GymMember {
    private final String name;
    private final LocalDate birthDate;

    public GymMember(String name, LocalDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GymMember gymMember = (GymMember) o;
        return Objects.equals(name, gymMember.name) && Objects.equals(birthDate, gymMember.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthDate);
    }

    @Override
    public String toString() {
        return "domain.GymMember{" +
                "name='" + name + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
