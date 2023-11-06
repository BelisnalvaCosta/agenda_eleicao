package com.bella.agenda_eleicao.agendaEleicaoApp;

import com.bella.agenda_eleicao.model.AgendaEleicao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
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
        dataSource.setUrl("jdbc:mysql://localhost:3306/agendaeleicaoapp");
        dataSource.setUsername("root");
        dataSource.setPassword(" ");
        return dataSource;
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter(){
        HibernateJpaVendorAdapter adapter= new HibernateJpaVendorAdapter();
        adapter.setDatabase(Database.MYSQL);
        adapter.setShowSql(true);
        adapter.setGenerateDdl(true);
        adapter.setDatabasePlatform("org.hibernate.dialect.mySQLDialect");
        adapter.setPrepareConnection(true);
        return adapter;
    }
}
