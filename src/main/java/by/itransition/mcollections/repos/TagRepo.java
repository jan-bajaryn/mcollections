package by.itransition.mcollections.repos;

import by.itransition.mcollections.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepo extends JpaRepository<Tag, Integer> {
}
