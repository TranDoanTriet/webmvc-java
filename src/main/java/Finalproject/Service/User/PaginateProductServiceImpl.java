package Finalproject.Service.User;

import org.springframework.stereotype.Service;

import Finalproject.Dto.PaginateDto;

@Service
public class PaginateProductServiceImpl implements IPaginateService{
	public PaginateDto GetInfoPagination(int totalData, int limit, int currentPage) {
        PaginateDto paginate = new PaginateDto();
        paginate.setLimit(limit);
        paginate.setTotalPage(calculateTotalPage(totalData, limit));
        paginate.setCurrentPage(checkCurrent(currentPage, paginate.getTotalPage()));
        
        int start = FindStart(paginate.getCurrentPage(), limit);
        paginate.setStart(start);
        
        int end = FindEnd(paginate.getStart(), limit, totalData);
        paginate.setEnd(end);
        
        return paginate;
    }

    private int FindEnd(int start, int limit, int totalData) {
        return start + limit > totalData ? totalData : (start + limit) - 1;
    }

    private int FindStart(int currentPage, int limit) {
        return (currentPage - 1) * limit + 1; 
    }

    private int calculateTotalPage(int totalData, int limit) {
    	int totalPage = 0;
    	totalPage = (int)totalData / limit;
    	totalPage = totalPage * limit < totalData ? totalData : totalPage;
        return totalPage;
    }
    
    private int checkCurrent(int current, int total) {
        if (current < 1) {
            return 1;
        }
        if (current > total) {
            return total;
        }
        return current;
    }
}
