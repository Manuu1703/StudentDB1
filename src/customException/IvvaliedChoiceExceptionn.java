package customException;

public class IvvaliedChoiceExceptionn extends RuntimeException
{
private String message;
public IvvaliedChoiceExceptionn(String message)
{
	this.message = message;
}
public String getmessag()
{
	return message;
}
}
