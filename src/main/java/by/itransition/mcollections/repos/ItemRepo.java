package by.itransition.mcollections.repos;

import by.itransition.mcollections.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepo extends JpaRepository<Item,Integer> {
}
