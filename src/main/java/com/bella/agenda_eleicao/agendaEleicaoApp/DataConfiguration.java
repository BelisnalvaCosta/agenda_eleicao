package com.bella.agenda_eleicao.agendaEleicaoApp;

import com.bella.agenda_eleicao.model.AgendaEleicao;
import org.hibernate.dialect.Database;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;


import javax.sql.DataSource;

@Configuration
public class DataConfiguration extends AgendaEleicao {
    private JpaVendorAdapter adapter;
    private Object HibernateJpaVendorAdapter;

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/eventosapp");
        dataSource.setUsername("root");
        dataSource.setPassword(" ");
        return dataSource;
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter(){
        HibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
        return adapter;
    }
}
