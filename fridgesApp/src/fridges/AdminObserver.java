/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fridges;

/**
 *
 * @author princenhodges
 */
import java.beans.PropertyChangeListener;

public interface AdminObserver {
    void addListener(PropertyChangeListener listener);
    void removeListener(PropertyChangeListener listener);
}