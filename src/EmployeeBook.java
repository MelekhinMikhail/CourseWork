public class EmployeeBook {
    private Employee[] array;

    public EmployeeBook(int maxLengthOfArray) {
        if (maxLengthOfArray > 0) this.array = new Employee[maxLengthOfArray];
        else throw new IllegalArgumentException("Длина массива не может быть отрицательной или равна нулю");
    }

    //Метод ниже добавляет в массив нового сотрудника, если массив переполнен, то пишет об этом в консоль
    public void addNewEmployee(String fullName, int department, double salary, int id) {
        boolean isFull = true;
        for (int i=0; i<array.length; i++) {
            if (array[i] == null) {
                array[i] = new Employee(fullName, department, salary, id);
                isFull = false;
                break;
            }
        }
        if(isFull) System.out.println("Книга переполнена!");
    }

    //Удаляет сотрудника из массива, если находит такое ФИО
    public void deleteEmployeeByFullName(String fullName) {
        for (int i=0; i<array.length; i++) {
            if (array[i] == null) continue;
            if (array[i].getFullName().equals(fullName)) {
                array[i] = null;
            }
        }
    }

    //Удаляет сотрудника из массива, если находит такой ID, иначе пишет в консоль, что такого ID нет
    public void deleteEmployeeById(int id) {
        boolean idHasFound = false;
        for (int i=0; i<array.length; i++) {
            if (array[i] == null) continue;
            if (array[i].getId() == id) {
                array[i] = null;
                idHasFound = true;
            }
        }
        if (!idHasFound) System.out.println("Сотрудника с ID: "+id+" нет в данной книге");
    }

    //Ищет сотрудника по указаному ФИО и меняет ему зарплату на указанную
    public void setSalaryOfEmployeeByFullName(String fullName, double salary) {
        for (Employee a:array) {
            if (a == null) continue;
            if (a.getFullName().equals(fullName)) {
                a.setSalary(salary);
            }
        }
    }

    //Ищет сотрудника по указаному ФИО и меняет ему отдел на указанный
    public void setDepartmentOfEmployeeByFullName(String fullName, int department) {
        for (Employee a:array) {
            if (a == null) continue;
            if (a.getFullName().equals(fullName)) {
                a.setDepartment(department);
            }
        }
    }

    //Выводит в консоль всех сотрудников, сортируя по отделу
    public void printAllEmployeesByDepartments() {
        System.out.println("1-й отдел:");
        for (Employee a:array) {
            if (a == null) continue;
            if(a.getDepartment() == 1) {
                System.out.println(a);
            }
        }
        System.out.println("2-й отдел:");
        for (Employee a:array) {
            if (a == null) continue;
            if(a.getDepartment() == 2) {
                System.out.println(a);
            }
        }
        System.out.println("3-й отдел:");
        for (Employee a:array) {
            if (a == null) continue;
            if(a.getDepartment() == 3) {
                System.out.println(a);
            }
        }
        System.out.println("4-й отдел:");
        for (Employee a:array) {
            if (a == null) continue;
            if(a.getDepartment() == 4) {
                System.out.println(a);
            }
        }
        System.out.println("5-й отдел:");
        for (Employee a:array) {
            if (a == null) continue;
            if(a.getDepartment() == 5) {
                System.out.println(a);
            }
        }
    }

    //Выводит в консоль всех сотрудников
    public void printAllEmployees() {
        for (Employee a : array) {
            if (a == null) continue;
            System.out.println(a);
        }
    }

    //Возвращает сумму зарплат всех сотрудников
    public double sumOfSalariesAllEmployees() {
        double sum = 0;
        for (Employee employee : array) {
            if (employee == null) continue;
            sum += employee.getSalary();
        }
        return sum;
    }

    //Возвращает ID сотрудника с минимальной зарплатой
    public int getIdOfEmployeeWithMinSalary() {
        double min = array[0].getSalary();
        int id = array[0].getId();
        for (int i=1; i<array.length;i++) {
            if (array[i] == null) continue;
            if (array[i].getSalary() < min) {
                min = array[i].getSalary();
                id = array[i].getId();
            }
        }
        return id;
    }

    //Возвращает ID сотрудника с максимальной зарплатой
    public int getIdOfEmployeeWithMaxSalary() {
        double max = array[0].getSalary();
        int id = array[0].getId();
        for (int i=1; i<array.length;i++) {
            if (array[i] == null) continue;
            if (array[i].getSalary() > max) {
                max = array[i].getSalary();
                id = array[i].getId();
            }
        }
        return id;
    }

    //Возвращает среднюю зарплату всех сотрудников
    public double averageSalaryOfAllEmployees() {
        double sum = this.sumOfSalariesAllEmployees();
        return (double) sum/array.length;
    }

    //Выводит в консоль ФИО всех сотрудников
    public void printAllEmployeesFullName() {
        for (Employee employee : array) {
            if (employee == null) continue;
            System.out.println(employee.getFullName());
        }
    }

    //Увеличивает зарплату всех сотрудников на заданное кол-во %
    public void indexTheSalaryOfAllEmployees(double percent) {
        for (Employee a : array) {
            if (a == null) continue;
            a.setSalary(a.getSalary()+(a.getSalary()*(percent/100)));
        }
    }

    //Возвращает ID сотрудника с минимальной зарплатой в указанном отделе
    public int getIdEmployeeWithMinSalaryByDepartment(int department) {
        if (department < 1) throw new IllegalArgumentException("Отдел не может быть отрицательным или равен нулю");
        double min = 1000000000;
        int id = -1;
        for (Employee a:array) {
            if (a == null) continue;
            if (a.getDepartment() == department) {
                if (a.getSalary() < min) {
                    min = a.getSalary();
                    id = a.getId();
                }
            }
        }
        return id;
    }

    //Возвращает ID сотрудника с максимальной зарплатой в указанном отделе
    public int getIdEmployeeWithMaxSalaryByDepartment(int department) {
        if (department < 1) throw new IllegalArgumentException("Отдел не может быть отрицательным или равен нулю");
        double max = -1;
        int id = -1;
        for (Employee a:array) {
            if (a == null) continue;
            if (a.getDepartment() == department) {
                if (a.getSalary() > max) {
                    max = a.getSalary();
                    id = a.getId();
                }
            }
        }
        return id;
    }

    //Возвращает сумму зарплат всех сотрудников в указанном отделе
    public double getSumOfSalariesByDepartment(int department) {
        if (department < 1) throw new IllegalArgumentException("Отдел не может быть отрицательным или равен нулю");
        double sum = 0;
        for (Employee a:array) {
            if (a == null) continue;
            if (a.getDepartment() == department) {
                sum += a.getSalary();
            }
        }
        return sum;
    }

    //Возвращает среднюю зарплату сотрудников в указанном отделе
    public double getAverageSalaryByDepartment(int department) {
        if (department < 1) throw new IllegalArgumentException("Отдел не может быть отрицательным или равен нулю");
        int count = 0;
        for (Employee a:array) {
            if (a == null) continue;
            if (a.getDepartment() == department) {
                count++;
            }
        }
        return (double) getSumOfSalariesByDepartment(department) / count;
    }

    //Увеличивает зарплаты всех сотрудников на указанное кол-во % в указанном отделе
    public void indexTheSalaryOfEmployeesByDepartment(int department, double percent) {
        if (department < 1) throw new IllegalArgumentException("Отдел не может быть отрицательным или равен нулю");
        for (Employee a : array) {
            if (a == null) continue;
            if (a.getDepartment() == department) {
                a.setSalary(a.getSalary()+(a.getSalary()*(percent/100)));
            }
        }
    }

    //Выводит в консоль всех сотрудников из указанного отдела
    public void printEmployeesByDepartment(int department) {
        if (department < 1) throw new IllegalArgumentException("Отдел не может быть отрицательным или равен нулю");
        for (Employee a:array) {
            if (a == null) continue;
            if (a.getDepartment() == department) {
                System.out.println("ФИО: "+a.getFullName()+"  Зарплата: "+a.getSalary()+" руб.  ID: "+a.getId());
            }
        }
    }

    //Выводит в консоль всех сотрудников, у которых З/П меньше указанной
    public void printEmployeesWithSalaryLessThan(double salary) {
        for (Employee a:array) {
            if (a == null) continue;
            if (a.getSalary() < salary) {
                System.out.println("ID: "+a.getId()+"  ФИО: "+a.getFullName()+"  Зарплата: "+a.getSalary()+" руб.");
            }
        }
    }

    //Выводит в консоль всех сотрудников, у которых З/П больше указанной
    public void printEmployeesWithSalaryMoreThan(double salary) {
        for (Employee a:array) {
            if (a == null) continue;
            if (a.getSalary() > salary) {
                System.out.println("ID: "+a.getId()+"  ФИО: "+a.getFullName()+"  Зарплата: "+a.getSalary()+" руб.");
            }
        }
    }
}
