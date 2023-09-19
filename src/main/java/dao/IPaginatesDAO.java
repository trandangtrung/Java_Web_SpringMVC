package dao;

import org.springframework.stereotype.Service;

import utils.Paginates;
@Service
public interface IPaginatesDAO {
	public Paginates GetInfoPaginates(int totalData, int limit, int currentPage);
}
