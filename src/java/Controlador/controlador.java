/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Config.GenerarNumeroSerie;
import Funtional.Ticket;
import Modelo.Customer;
import Modelo.CustomerDao;
import Modelo.Empleado;
import Modelo.EmpleadoDao;
import Modelo.Product;
import Modelo.ProductDao;
import Modelo.Sales;
import Modelo.SalesDao;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Meza
 */
public class controlador extends HttpServlet {

    Empleado model = new Empleado();
    EmpleadoDao dao = new EmpleadoDao();
    int IdEmp;

    Customer customerModel = new Customer();
    CustomerDao customerDao = new CustomerDao();
    int IdCust;

    Product ProductModel = new Product();
    ProductDao ProductDao = new ProductDao();
    int IdProd;

    Sales sls = new Sales();
    List<Sales> MyList = new ArrayList<>();
    int item;
    int codprod;
    String descrip;
    double preUnit;
    int CantPed;
    double TotPag;

    SalesDao sDao = new SalesDao();
    String NumSerie;

    Ticket ticket = new Ticket();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        if (menu.equals("Principal")) {
            request.getRequestDispatcher("Principal.jsp").forward(request, response);
        }
        if (menu.equals("Home")) {
            request.getRequestDispatcher("Design/Home.jsp").forward(request, response);
        }
        if (menu.equals("Empleado")) {
            switch (accion) {
                case "Listar":
                    List myList = dao.ListEmpleado();
                    request.setAttribute("Empleados", myList);
                    break;
                case "Registrar":
                    String dni = request.getParameter("txtDni");
                    String nombre = request.getParameter("txtNombre");
                    String telefono = request.getParameter("txtTelefono");
                    String estado = request.getParameter("txtEstado");
                    String usuario = request.getParameter("txtUsuario");
                    model.setNumDoc(dni);
                    model.setEmpleyees(nombre);
                    model.setTelNumb(telefono);
                    model.setEstado(Integer.parseInt(estado));
                    model.setUser(usuario);
                    dao.Agregar(model);
                    request.getRequestDispatcher("controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    IdEmp = Integer.parseInt(request.getParameter("id"));
                    Empleado els = dao.ListId(IdEmp);
                    request.setAttribute("Empleado", els);
                    request.getRequestDispatcher("controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String dniUp = request.getParameter("txtDni");
                    String nombreUp = request.getParameter("txtNombre");
                    String telefonoUp = request.getParameter("txtTelefono");
                    String estadoUp = request.getParameter("txtEstado");
                    String usuarioUp = request.getParameter("txtUsuario");
                    model.setNumDoc(dniUp);
                    model.setEmpleyees(nombreUp);
                    model.setTelNumb(telefonoUp);
                    model.setEstado(Integer.parseInt(estadoUp));
                    model.setUser(usuarioUp);
                    model.setId(IdEmp);
                    dao.Actualizar(model);
                    request.getRequestDispatcher("controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                case "Eliminar":
                    IdEmp = Integer.parseInt(request.getParameter("id"));
                    dao.Eliminar(IdEmp);
                    request.getRequestDispatcher("controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
            }
            request.getRequestDispatcher("Design/Empleados.jsp").forward(request, response);
        }
        if (menu.equals("Customer")) {
            switch (accion) {
                case "List":
                    List ListCust = customerDao.ListCustomer();
                    request.setAttribute("Customers", ListCust);
                    break;
                case "Registrar":
                    String Dni = request.getParameter("txtDni");
                    String Customer = request.getParameter("txtNombre");
                    String Address = request.getParameter("txtDireccion");
                    String Status = request.getParameter("txtEstado");
                    customerModel.setDni(Dni);
                    customerModel.setCustomer(Customer);
                    customerModel.setAddress(Address);
                    customerModel.setStatus(Integer.parseInt(Status));
                    customerDao.Insert(customerModel);
                    request.getRequestDispatcher("controlador?menu=Customer&accion=List").forward(request, response);
                    break;
                case "Edit":
                    IdCust = Integer.parseInt(request.getParameter("id"));
                    Customer ctm = customerDao.ListId(IdCust);
                    request.setAttribute("Customer", ctm);
                    request.getRequestDispatcher("controlador?menu=Customer&accion=List").forward(request, response);
                    break;
                case "Actualizar":
                    String DniUp = request.getParameter("txtDni");
                    String CustomerUp = request.getParameter("txtNombre");
                    String AddressUp = request.getParameter("txtDireccion");
                    String StatusUp = request.getParameter("txtEstado");
                    customerModel.setDni(DniUp);
                    customerModel.setCustomer(CustomerUp);
                    customerModel.setAddress(AddressUp);
                    customerModel.setStatus(Integer.parseInt(StatusUp));
                    customerModel.setId(IdCust);
                    customerDao.Update(customerModel);
                    request.getRequestDispatcher("controlador?menu=Customer&accion=List").forward(request, response);
                    break;
                case "Delete":
                    IdCust = Integer.parseInt(request.getParameter("id"));
                    customerDao.Delete(IdCust);
                    request.getRequestDispatcher("controlador?menu=Customer&accion=List").forward(request, response);
                    break;
            }
            request.getRequestDispatcher("Design/Clientes.jsp").forward(request, response);
        }
        if (menu.equals("Products")) {
            switch (accion) {
                case "List":
                    List ListCust = ProductDao.ListProduct();
                    request.setAttribute("Productos", ListCust);
                    break;
                case "Registrar":
                    String Product = request.getParameter("txtProduct");
                    String Amount = request.getParameter("txtPrecio");
                    String Stock = request.getParameter("txtStock");
                    String Status = request.getParameter("txtEstad");
                    ProductModel.setProduct(Product);
                    ProductModel.setAmount(Double.parseDouble(Amount));
                    ProductModel.setStock(Integer.parseInt(Stock));
                    ProductModel.setStatus(Integer.parseInt(Status));
                    ProductDao.Insert(ProductModel);
                    request.getRequestDispatcher("controlador?menu=Products&accion=List").forward(request, response);
                    break;
                case "Edit":
                    IdProd = Integer.parseInt(request.getParameter("id"));
                    Product prod = ProductDao.ListId(IdProd);
                    request.setAttribute("Product", prod);
                    request.getRequestDispatcher("controlador?menu=Products&accion=List").forward(request, response);
                    break;
                case "Actualizar":
                    String ProductUp = request.getParameter("txtProduct");
                    String AmountUp = request.getParameter("txtPrecio");
                    String StockUp = request.getParameter("txtStock");
                    String StatusUp = request.getParameter("txtEstad");
                    ProductModel.setProduct(ProductUp);
                    ProductModel.setAmount(Double.parseDouble(AmountUp));
                    ProductModel.setStock(Integer.parseInt(StockUp));
                    ProductModel.setStatus(Integer.parseInt(StatusUp));
                    ProductModel.setId(IdProd);
                    ProductDao.Update(ProductModel);
                    request.getRequestDispatcher("controlador?menu=Products&accion=List").forward(request, response);
                    break;
                case "Delete":
                    IdProd = Integer.parseInt(request.getParameter("id"));
                    ProductDao.Delete(IdProd);
                    request.getRequestDispatcher("controlador?menu=Products&accion=List").forward(request, response);
                    break;
            }
            request.getRequestDispatcher("Design/Productos.jsp").forward(request, response);
        }
        if (menu.equals("Sales")) {
            NumSerie = sDao.GenerarSerie();
            if (NumSerie != null) {
                int increment = Integer.parseInt(NumSerie);
                GenerarNumeroSerie gs = new GenerarNumeroSerie();
                NumSerie = gs.NumeroSerie(increment);
            } else {
                NumSerie = "0000000001";
            }
            switch (accion) {
                case "Buscar":
                    String dni = request.getParameter("txtCodCli");
                    customerModel.setDni(dni);
                    customerModel = customerDao.Search(dni);
                    request.setAttribute("search", customerModel);
                    request.setAttribute("NumSerie", NumSerie);
                    request.setAttribute("Lista", MyList);
                    break;
                case "buscar":
                    int id = Integer.parseInt(request.getParameter("txtCodProd"));
                    Product pd = ProductDao.ListId(id);
                    request.setAttribute("Productos", pd);
                    request.setAttribute("Lista", MyList);
                    request.setAttribute("TotalPag", TotPag);
                    request.setAttribute("search", customerModel);
                    request.setAttribute("NumSerie", NumSerie);
                    break;
                case "Agregar":
                    request.setAttribute("search", customerModel);
                    TotPag = 0;
                    codprod = Integer.parseInt(request.getParameter("txtCodProd"));
                    descrip = request.getParameter("txtProd");
                    preUnit = Double.parseDouble(request.getParameter("txtPrecio"));
                    CantPed = Integer.parseInt(request.getParameter("txtCantidad"));
                    boolean Band = false;
                    if (MyList.isEmpty()) {
                        sls = new Sales();
                        item += 1;
                        sls.setItem(item);
                        sls.setIdProd(codprod);
                        sls.setDescrip(descrip);
                        sls.setPrecio(preUnit);
                        sls.setCant(CantPed);
                        sls.setSubTot(preUnit * CantPed);
                        MyList.add(sls);
                        for (int j = 0; j < MyList.size(); j++) {
                            TotPag += MyList.get(j).getSubTot();
                        }
                    } else {
                        for (int i = 0; i < MyList.size(); i++) {
                            if (codprod != MyList.get(i).getIdProd()) {
                                Band = true;
                            }
                        }
                        if (Band) {
                            sls = new Sales();
                            item += 1;
                            sls.setItem(item);
                            sls.setIdProd(codprod);
                            sls.setDescrip(descrip);
                            sls.setPrecio(preUnit);
                            sls.setCant(CantPed);
                            sls.setSubTot(preUnit * CantPed);
                            MyList.add(sls);
                            for (int j = 0; j < MyList.size(); j++) {
                                TotPag += MyList.get(j).getSubTot();
                            }
                        } else {
                            for (int i = 0; i < MyList.size(); i++) {
                                if (codprod == MyList.get(i).getIdProd()) {
                                    CantPed += Integer.parseInt(request.getParameter("txtCantidad"));
                                    MyList.get(i).setCant(CantPed);
                                    MyList.get(i).setSubTot(preUnit * CantPed);
                                    for (int j = 0; j < MyList.size(); j++) {
                                        TotPag += MyList.get(j).getSubTot();
                                    }
                                }
                            }
                        }
                    }
                    request.setAttribute("TotalPag", TotPag);
                    request.setAttribute("Lista", MyList);
                    request.setAttribute("NumSerie", NumSerie);
                    break;
                case "Generar":
                    if (!MyList.isEmpty()) {
                        for (int i = 0; i < MyList.size(); i++) {
                            Product pr = new Product();
                            int cant = MyList.get(i).getCant();
                            int Id = MyList.get(i).getIdProd();
                            ProductDao pdao = new ProductDao();
                            pr = pdao.Buscar(Id);
                            int NewStk = pr.getStock() - cant;
                            pdao.ActualizaStok(Id, NewStk);
                        }
                        /**
                         * * Guardar Ventas **
                         */
                        int idCus = customerModel.getId();
                        if (idCus != 0) {
                            sls.setIdCli(customerModel.getId());
                        } else {
                            sls.setIdCli(null);
                        }
                        sls.setIdEmp(Empleado.getIdLog());
                        sls.setNumSerie(NumSerie);
                        Date date = new Date();
                        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
                        String strDate = formatter.format(date);
                        sls.setFecha(strDate);
                        sls.setMont(TotPag);
                        sls.setStado(1);
                        sDao.GuardarVentas(sls);
                        int idV = Integer.parseInt(sDao.IdVenta());
                        for (int i = 0; i < MyList.size(); i++) {
                            sls = new Sales();
                            sls.setId(idV);
                            sls.setIdProd(MyList.get(i).getIdProd());
                            sls.setCant(MyList.get(i).getCant());
                            sls.setPrecio(MyList.get(i).getPrecio());
                            sDao.GuardarDetalle(sls);
                        }
                    }
                    
                    int increment = Integer.parseInt(NumSerie);
                    GenerarNumeroSerie gs = new GenerarNumeroSerie();
                    NumSerie = gs.NumeroSerie(increment);
                    MyList.clear();
                    item = 0;
                    request.setAttribute("NumSerie", NumSerie);
                    break;
//                case "Editar":
//                    
//                    break;
                case "Quitar":
//                    int idP = Integer.parseInt(request.getParameter("idP"));
//                    for (int i = 0; i < MyList.size(); i++) {
//                        if (MyList.get(i).getItem() == idP) {
//                            MyList.remove(i);
//                        }
//                    }
                    request.setAttribute("Lista", MyList);
                    break;
                case "Cancelar":
                    MyList.clear();
                    item = 0;
                    request.setAttribute("NumSerie", NumSerie);
                    break;
                default:
                    MyList.clear();
                    item = 0;
                    request.setAttribute("NumSerie", NumSerie);
                    break;
            }
            request.getRequestDispatcher("Design/Sales.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
