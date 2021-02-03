import entity.Employee;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class EmployeeDao extends AbstractJpaDao<Employee,Integer> {

    public EmployeeDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Employee> getEntityClass() {
        return Employee.class;
    }
    public List<Employee> loadall ( )
    {
        CriteriaBuilder cb=entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery=cb.createQuery(getEntityClass());
        Root<Employee> employeeRoot=criteriaQuery.from(Employee.class);
        criteriaQuery.select(employeeRoot);
        return entityManager.createQuery(criteriaQuery).getResultList();
    }
    public Employee loadEmployeeById(Integer id ) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery = cb.createQuery(Employee.class);
        Root<Employee> employeeRoot = criteriaQuery.from(Employee.class);

        criteriaQuery.select(employeeRoot).where(cb.equal(employeeRoot.get("id"),id));

        return entityManager.createQuery(criteriaQuery).getSingleResult();
    }
}
