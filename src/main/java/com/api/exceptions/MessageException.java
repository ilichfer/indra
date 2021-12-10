package com.api.exceptions;

public class MessageException extends RuntimeException  {
	
	 private int codigoError;
	 private String mensaje;

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	
	 public MessageException(int codigoError){
	        super();
	        this.codigoError=codigoError;
	    }
	
	 
	    @Override
	    public String getMessage(){
	         
	        String mensaje="";
	         
	        switch(codigoError){
	            case 400:
	                mensaje="La cantidad de datos son insufientes";
	                break;
	            case 401:
	                mensaje="los datos son incorrecto";
	                break;
	            case 402:
	                mensaje="No se puede conocer el mensaje";
	                break;
	        }
	         
	        return mensaje;
	         
	    }
}
