/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;


/**
 *
 * @author lucas
 */
public class Wallpaper extends JDesktopPane{
    private Image image;
    
    public Wallpaper(String image){
        this.image = new ImageIcon(image).getImage();
    }
    
    @Override
    public void paintComponent(Graphics g){
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
    }
}
