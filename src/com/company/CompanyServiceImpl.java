/* CompanyServiceImpl
 *
 * Version 1
 *
 * @author Nataliia Zviertseva, KhPI
 * COMPANY Service implementation
 */

package com.company;
import javafx.util.Pair;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class CompanyServiceImpl implements ICompanyService {
    public CompanyServiceImpl() {
    }

    public Company getTopLevelParent(Company child) {
        return child.getParent() == null ? child : this.getTopLevelParent(child.getParent());
    }

    public long getEmployeeCountForCompanyAndChildren(Company company, List<Company> companies) {
        Pair<Long, List<Company>> initPair = this.getChildElementsFromCompany(company, companies, company.getEmployeesCount());
        List<Company> companyToSearch = (List)initPair.getValue();
        Long count = (Long)initPair.getKey();

        for(int i = 0; i < companyToSearch.size(); ++i) {
            Pair<Long, List<Company>> iterationResult = this.getChildElementsFromCompany((Company)companyToSearch.get(i), companies, count);
            companyToSearch.addAll((Collection)iterationResult.getValue());
            count = (Long)iterationResult.getKey();
        }

        return count;
    }

    private Pair<Long, List<Company>> getChildElementsFromCompany(Company searchItem, List<Company> companies, Long count) {
        List<Company> childList = new ArrayList();
        Iterator var5 = companies.iterator();

        while(var5.hasNext()) {
            Company company = (Company)var5.next();
            if (searchItem.equals(company.getParent())) {
                childList.add(company);
                count = count + company.getEmployeesCount();
            }
        }

        return new Pair(count, childList);
    }
}