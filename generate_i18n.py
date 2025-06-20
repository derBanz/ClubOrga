from Banz_i18n_codegenerator import generator

generator.run(['i18n_de.properties', 'i18n_en.properties'], '.\\backend\\domain\\src\\main\\resources', '.\\backend\\domain\\src\\main\\java\\org\\derbanz\\cluborga\\domain\\i18n', 'org.derbanz.cluborga.domain.base.I18N')
