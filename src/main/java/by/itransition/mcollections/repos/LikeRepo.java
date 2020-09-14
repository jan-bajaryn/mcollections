package by.itransition.mcollections.repos;

import by.itransition.mcollections.entity.MyLike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepo extends JpaRepository<MyLike,Integer> {
}
