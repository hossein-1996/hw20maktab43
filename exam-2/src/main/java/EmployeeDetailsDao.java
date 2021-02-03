import entity.Employee;
import entity.EmployeeDetails;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class EmployeeDetailsDao extends AbstractJpaDao<EmployeeDetails,Integer> {
    public EmployeeDetailsDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<EmployeeDetails> getEntityClass() {
        return EmployeeDetails.class;
    }
    public EmployeeDetails loadEmployeeDetailsById(Integer id ) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<EmployeeDetails> criteriaQuery = cb.createQuery(EmployeeDetails.class);
        Root<EmployeeDetails> employeeDetailsRoot = criteriaQuery.from(EmployeeDetails.class);
        Root<Employee> employeeRoot = criteriaQuery.from(Employee.class);

        criteriaQuery.select(employeeDetailsRoot).where(cb.and(cb.equal(employeeRoot.get("id"),id),
                cb.equal(employeeDetailsRoot.get("employee"),employeeRoot.get("id"))));

        return entityManager.createQuery(criteriaQuery).getSingleResult();
    }
}
