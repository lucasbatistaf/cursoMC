package com.lucasbatista.cursomc2.services.validation;

import com.lucasbatista.cursomc2.domain.Client;
import com.lucasbatista.cursomc2.domain.enums.TypeClient;
import com.lucasbatista.cursomc2.dto.ClientNewDTO;
import com.lucasbatista.cursomc2.resources.exception.FieldMessage;
import com.lucasbatista.cursomc2.services.validation.utils.BR;

import java.util.ArrayList;
import java.util.List;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ClientInsertValidator implements ConstraintValidator<ClientInsert, ClientNewDTO> {
    @Override
    public void initialize(ClientInsert ann) {
    }

    @Override
    public boolean isValid(ClientNewDTO objDto, ConstraintValidatorContext context) {
        List<FieldMessage> list = new ArrayList<>();

        if (objDto.getTypeClient().equals(TypeClient.PESSOAFISICA.getCod()) && !BR.isValidCPF(objDto.getCpfOrCnpj())) {
            list.add(new FieldMessage("cpfOuCnpj", "Invalid CPF"));
        }

        if (objDto.getTypeClient().equals(TypeClient.PESSOAJURIDICA.getCod()) && !BR.isValidCNPJ(objDto.getCpfOrCnpj())) {
            list.add(new FieldMessage("cpfOuCnpj", "Invalid CNPJ"));
        }
        
        for (FieldMessage e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage())
                    .addPropertyNode(e.getFieldName()).addConstraintViolation();
        }
        return list.isEmpty();
    }
}
