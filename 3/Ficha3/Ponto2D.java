
/**
 * Write a description of class Ponto2D here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Ponto2D
{
    private int x;
    private int y;
    
    public Ponto2D(){
        this.x = 0;
        this.y = 0;
    }
    
    public Ponto2D(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public Ponto2D ( Ponto2D umPonto ) {
        this . x = umPonto.getX() ;
        this . y = umPonto.getY() ;
    }
    
    public int getX () {
        return this.x ;
    }
    
    public int getY () {
        return this.y ;
    }
    
    public void setX ( int novoX ) {
        this.x = novoX ;
    }
    
    public void setY ( int novoY ) {
        this.y = novoY ;
    }
    
    public void deslocamento ( int deltaX , int deltaY ) {
        this.x += deltaX ;
        this . y += deltaY ;
    }
    
    public void somaPonto ( Ponto2D umPonto ) {
        this.x += umPonto.getX() ;
        this.y += umPonto.getY() ;
    }
    
    public void movePonto ( int cx , int cy ) {
        this . x = cx ; // ou setX ( cx )
        this . y = cy ; // ou this . setY ( cy )
    }
    
    public boolean ePositivo () {
        return ( this.x > 0 && this.y > 0) ;
    }
    
    public double distancia ( Ponto2D umPonto ) {
        return Math . sqrt ( Math . pow ( this . x - umPonto . getX () , 2) +
        Math . pow ( this . y - umPonto . getY () , 2) ) ;
    }
    
    private boolean xIgualAy () {
        return ( Math . abs ( this . x ) == Math . abs ( this . y ) ) ;
    }   
    
    public boolean equals ( Object o ) {
        if ( this == o )
            return true ;
        if (( o == null ) || ( this.getClass () != o.getClass () ) )
            return false ;
        Ponto2D p = ( Ponto2D ) o ;
            return ( this.x == p.getX () && this.y == p.getY () ) ;
        }
        
    public String toString () {
        return " Cx = " + this.x + " - Cy = " + this.y ;
    }
    
    public Ponto2D clone () {
        return new Ponto2D ( this ) ;
    }
    
    
    
    
}
