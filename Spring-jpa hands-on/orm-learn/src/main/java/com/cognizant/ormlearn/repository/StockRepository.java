package com.cognizant.ormlearn.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.ormlearn.model.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer> {

	@Query("select s from Stock s where s.stockCode=?1 and month(s.stockDate)=?2 and year(s.stockDate)=?3")
	public List<Stock> findStockByCodeAndMonthAndYear(String code, int month, int year);
	
	// Get all google stock details where the stock price was greater than 1250
	@Query("select s from Stock s where s.stockCode=?1 and s.closingStock>1250")
	public List<Stock> findGoogleStockByNameAndPrice(String code);
	//Find the top 3 dates which had highest volume of transaction
	//@Query("select s from Stock s order by s.volume desc LIMIT 3")
	@Query("select s from Stock s")
	public List<Stock> findThreeHighestVolumeStock(Pageable pageable);
	
	public List<Stock> findByOrderByVolume();
	//Identify three dates when Netflix stocks were the lowest
//	@Query("select s from Stock s where s.stockCode=?1 order by min(s.closingStock) asc limit 3")
//	public List<Stock> findLowestNetflixstock(String code);

}
