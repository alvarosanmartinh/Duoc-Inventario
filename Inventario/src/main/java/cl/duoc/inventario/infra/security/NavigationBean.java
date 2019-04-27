/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.inventario.infra.security;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author 3it
 */
@Named(value = "navigationBean")
@SessionScoped
public class NavigationBean implements Serializable {

    private static final long serialVersionUID = 1520318172495977648L;
    
    /**
     * Creates a new instance of NavigationBean
     */
    public NavigationBean() {
    }
    
    /**
     * Redirect to login page.
     * @return Login page name.
     */
    public String redirectToLogin() {
        return "/login.jsf?faces-redirect=true";
    }
     
    /**
     * Go to login page.
     * @return Login page name.
     */
    public String toLogin() {
        return "/login.jsf";
    }
     
    /**
     * Redirect to index page.
     * @return Index page name.
     */
    public String redirectToIndex() {
        return "/index.jsf?faces-redirect=true";
    }
     
    /**
     * Go to index page.
     * @return Index page name.
     */
    public String toIndex() {
        return "/index.jsf";
    }
     
    /**
     * Redirect to dashboard page.
     * @return Dashboard page name.
     */
    public String redirectToDashboard() {
        return "/private/dashboard.jsf?faces-redirect=true";
    }
     
    /**
     * Go to dashboard page.
     * @return Dashboard page name.
     */
    public String toDashboard() {
        return "/private/dashboard.jsf";
    }
        
    /**
     * Redirect to producto list page.
     * @return producto list page name.
     */
    public String redirectProductoList() {
        return "/private/product-list.jsf?faces-redirect=true";
    }
     
    /**
     * Go to producto list page.
     * @return producto list page name.
     */
    public String toProductoList() {
        return "/private/product-list.jsf";
    }
    
    /**
     * Redirect to usuario list page.
     * @return usuario list page name.
     */
    public String redirectUsuarioList() {
        return "/private/usuario-list.jsf?faces-redirect=true";
    }
     
    /**
     * Go to usuario list page.
     * @return usuario list page name.
     */
    public String toUsuarioList() {
        return "/private/usuario-list.jsf";
    }
    
    /**
     * Redirect to usuario form page.
     * @return usuario form page name.
     */
    public String redirectUsuarioForm() {
        return "/private/usuario-form.jsf?faces-redirect=true";
    }
     
    /**
     * Go to usuario form page.
     * @return usuario form page name.
     */
    public String toUsuarioForm() {
        return "/private/usuario-form.jsf";
    }
    
    /**
     * Redirect to producto form page.
     * @return producto form page name.
     */
    public String redirectProductoForm() {
        return "/private/product-form.jsf?faces-redirect=true";
    }
     
    /**
     * Go to producto form page.
     * @return producto form page name.
     */
    public String toProductoForm() {
        return "/private/product-form.jsf";
    }
}
