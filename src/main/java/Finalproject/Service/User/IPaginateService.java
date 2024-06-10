package Finalproject.Service.User;

import org.springframework.stereotype.Service;

import Finalproject.Dto.PaginateDto;

@Service
public interface IPaginateService {
	public PaginateDto GetInfoPagination(int totalData,int limit, int currentPage);
}
