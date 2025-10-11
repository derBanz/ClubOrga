from Banz_domainfile_generator import domainfile_generator as generator

csv = 'organization;Person;name,STRING,required;firstName,STRING;dateOfBirth,DATE;gender,ENUM(Gender/MALE/FEMALE/DIVERSE),required;memberships,INCOMING_REFERENCE(organization.Membership/n);contacts,INCOMING_REFERENCE(organization.Contact/n)'
csv += '\norganization;Membership;validFrom,DATE,required;validTo,DATE;discount,BOOLEAN,required;status,ENUM(MembershipStatus/APPLICATION/ACTIVE_MEMBER/INACTIVE_MEMBER/FORMER_MEMBER/DECLINED),required;person,REFERENCE(organization.Person/1),required'

paths = {
    'domain': '\\backend\\domain\\src\\main\\java\\org\\derbanz\\cluborga\\domain\\',
    'schema': '\\backend\\domain\\src\\main\\resources\\schema\\',
    'logic': '\\backend\\logic\\src\\main\\java\\org\\derbanz\\cluborga\\logic\\',
    'commonService': '\\backend\\service\\common\\src\\main\\java\\org\\derbanz\\cluborga\\commonservice\\',
    'uiService': '\\backend\\service\\ui\\src\\main\\java\\org\\derbanz\\cluborga\\uiservice\\'
}
generator.run(csv, paths)
