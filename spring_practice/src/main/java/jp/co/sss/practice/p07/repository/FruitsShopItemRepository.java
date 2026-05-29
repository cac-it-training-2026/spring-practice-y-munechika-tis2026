package jp.co.sss.practice.p07.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jp.co.sss.practice.p07.entity.FruitsShopItem;
import jp.co.sss.practice.p07.entity.Type;

public interface FruitsShopItemRepository extends JpaRepository<FruitsShopItem, Integer> {
	@Query("SELECT f FROM FruitsShopItem f WHERE f.price BETWEEN :min AND :max AND f.type=:type ORDER BY f.price,f.itemId")
	public List<FruitsShopItem> findByPriceRangeAndType(@Param("min") Integer min, @Param("max") Integer max,
			@Param("type") Type type);

	@Query("SELECT t FROM FruitsShopItem f INNER JOIN Type t ON f.type.typeId = t.typeId GROUP BY t ORDER BY COUNT(f.type) DESC, t.typeId")
	public List<Type> findQuerySortByTypeCount();
}
