package com.uth.biblioteca.views.autores;

import com.uth.biblioteca.controller.AutoresInteractor;
import com.uth.biblioteca.controller.AutoresInteractorImpl;
import com.uth.biblioteca.data.Autor;
import com.uth.biblioteca.views.MainLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Header;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.AfterNavigationEvent;
import com.vaadin.flow.router.AfterNavigationObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@PageTitle("Autores")
@Route(value = "autores", layout = MainLayout.class)
public class AutoresView extends Div implements AfterNavigationObserver, AutoresViewModel {

    Grid<Person> grid = new Grid<>();
    private AutoresInteractor controller;

    public AutoresView() {
    	
        addClassName("autores-view");
        setSizeFull();
        
        controller = new AutoresInteractorImpl(this);
        
        grid.setHeight("100%");
        grid.addThemeVariants(GridVariant.LUMO_NO_BORDER, GridVariant.LUMO_NO_ROW_BORDERS);
        grid.addComponentColumn(person -> createCard(person));
        
        controller.consultarAutores();
        
        add(grid);
    }

    private HorizontalLayout createCard(Person person) {
        HorizontalLayout card = new HorizontalLayout();
        card.addClassName("card");
        card.setSpacing(false);
        card.getThemeList().add("spacing-s");

        Image image = new Image();
        image.setSrc(person.getImage());
        VerticalLayout description = new VerticalLayout();
        description.addClassName("description");
        description.setSpacing(false);
        description.setPadding(false);

        HorizontalLayout header = new HorizontalLayout();
        header.addClassName("header");
        header.setSpacing(false);
        header.getThemeList().add("spacing-s");

        Span name = new Span(person.getName());
        name.addClassName("name");
        Span date = new Span(person.getDate());
        date.addClassName("date");
        header.add(name, date);

        Span post = new Span(person.getPost());
        post.addClassName("post");

        HorizontalLayout actions = new HorizontalLayout();
        actions.addClassName("actions");
        actions.setSpacing(false);
        actions.getThemeList().add("spacing-s");

        Icon calendarIcon = VaadinIcon.CALENDAR.create();
        calendarIcon.addClassName("icon");
        Span likes = new Span(person.getLikes());
        likes.addClassName("likes");
        Icon commentIcon = VaadinIcon.BOOK.create();
        commentIcon.addClassName("icon");
        Span comments = new Span(person.getComments());
        comments.addClassName("comments");
        Icon shareIcon = VaadinIcon.CONNECT.create();
        shareIcon.addClassName("icon");
        Span shares = new Span(person.getShares());
        shares.addClassName("shares");

        actions.add(calendarIcon, likes, commentIcon, comments, shareIcon, shares);

        description.add(header, post, actions);
        card.add(image, description);
        return card;
    }

    @Override
    public void afterNavigation(AfterNavigationEvent event) {

       

        

        //grid.setItems(persons);
    }

    private static Person createPerson(String image, String name, String date, String post, String likes,
            int comments, String shares) {
        Person p = new Person();
        p.setImage(image);
        p.setName(name);
        p.setDate(date);
        p.setPost(post);
        p.setLikes(likes);
        p.setComments(String.valueOf(comments));
        p.setShares(shares);

        return p;
    }

	@Override
	public void mostrarAutoresEnLista(List<Autor> items) {
		List<Person> persons = new ArrayList<>();
		
		for (Autor autor : items) {
			persons.add(createPerson("https://randomuser.me/api/portraits/lego/1.jpg", autor.getNombre(), autor.getNacimiento(),
					autor.getBiografia(),
                    "30-01-2000", autor.getCantidad_libros(), "20"));
			
		}
		

        grid.setItems(persons);
	}

	@Override
	public void mostrarMensajeExito(String mensaje) {
		Notification.show(mensaje);
	}

	@Override
	public void mostrarMensajeError(String mensaje) {
		Notification.show(mensaje);
	}

}
